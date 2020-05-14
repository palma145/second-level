package es.second.level.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
@Order(2)
public class ProductoAspect {

	@Around(value = "execution(public * es.second.level.services.*.get*(..))")
	public Object adviceGetUserById(ProceedingJoinPoint pjp) {
	
		log.info("*** Aspecto que mide tiempos para metodos get");
		Object returnObject = null;
		
		try {
			long startTime = System.currentTimeMillis();
			
			returnObject = pjp.proceed();
			Thread.sleep(500);
			
			long endTime = System.currentTimeMillis() - startTime;
			log.info("*** El metodo :: "+pjp.getSignature().getName() +", tiempo en ms ::"+ endTime);
			
		}catch(Throwable e) {
			
			log.info("*** Error al ejecutar el metodo :: "+ pjp.getSignature().getName());
		}	
		
		return returnObject;
	}
}
