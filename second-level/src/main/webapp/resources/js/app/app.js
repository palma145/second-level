Ext.require(['Ext.data.*', 'Ext.grid.*', 'Ext.ux.grid.FiltersFeature']);

Ext.define('ProductoDto', {
    extend: 'Ext.data.Model',
    fields: [ 'id', 'name', 'price'],
    validations: [{
            type: 'length',
            field: 'name',
            min: 1
        }, {
            type: 'length',
            field: 'price',
            min: 1
        }]
});

Ext.onReady(function() {

    var store = Ext.create('Ext.data.Store', {
        autoLoad: true,
        autoSync: true,
        model: 'ProductoDto',
        proxy: {
            type: 'rest',
            url: 'productos',
            appendId: false,
            headers: {
                'Content-Type': 'application/json'
            },
            reader: {
                type: 'json',
            },
            writer: {
                type: 'json'
            },
            api: {
                create: 'create',
                read: 'read',
                update: 'edit',
                destroy: 'delete'
            }
        }
    });

    var rowEditing = Ext.create('Ext.grid.plugin.RowEditing',{
    	listeners: {
        	'edit': function(editor){ console.log('dblclick body'); }
    	}
    });

    var filtersCfg = {
    	    ftype: 'filters',
    	    local: true,
    	    filters: [{
    	        type: 'string',
    	        dataIndex: 'name'
    	    }]
    	};
    
    var grid = Ext.create('Ext.grid.Panel', {
        renderTo: document.body,
        plugins: [rowEditing],
        width: 400,
        height: 300,
        frame: true,
        title: 'Products',
        store: store,
        features: [filtersCfg],
        columns: [{
                text: 'ID',
                width: 40,
                sortable: true,
                dataIndex: 'id'
            }, {
                text: 'Name',
                flex: 1,
                sortable: true,
                dataIndex: 'name',
                field: {
                   xtype: 'textfield'
                }
            }, {
                header: 'Price',
                width: 80,
                sortable: true,
                dataIndex: 'price',
                field: {
                    xtype: 'textfield'
                }
            }],
        dockedItems: [{
                xtype: 'toolbar',
                items: [{
                        text: 'Add',
                        iconCls: 'icon-add',
                        handler: function() {
                            // empty record
                            store.insert(0, new ProductoDto());
                            rowEditing.startEdit(0, 0);
                        }
                    }, '-', {
                        text: 'Delete',
                        iconCls: 'icon-delete',
                        handler: function() {
                            var selection = grid.getView().getSelectionModel().getSelection()[0];
                            if (selection) {
                                store.remove(selection);
                            }
                        }
                    }]
            }]
    });
    
    grid.filters
});