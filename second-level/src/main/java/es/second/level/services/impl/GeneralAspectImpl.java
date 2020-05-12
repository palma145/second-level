package es.second.level.services.impl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
@Order(1)
public class GeneralAspectImpl {

	@Around(value = "execution(public * es.second.level.services.*.get*(..))")
	public Object adviceGeneral(ProceedingJoinPoint pjp) {
		
		try {		
			
			log.info("*** Aspecto general para todos los metodos get");
			return pjp.proceed();
			
		}catch(Throwable e) {
			
			log.info("*** Error al ejecutar el metodo :: "+ pjp.getSignature().getName());
		}	
		
		return null;
	}
}
