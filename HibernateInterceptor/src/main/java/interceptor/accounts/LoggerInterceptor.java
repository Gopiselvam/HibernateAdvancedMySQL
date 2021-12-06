package interceptor.accounts;

import org.apache.log4j.Logger;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import java.io.Serializable;

public class LoggerInterceptor extends EmptyInterceptor {
    Logger logger = Logger.getLogger(LoggerInterceptor.class);

    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState,
                                Object[] previousState, String[] propertyNames, Type[] types) {
        if(entity instanceof Account){
            logger.debug("Updating Balance for account number: "+((Account) entity).getAccountNumber());
        }
        return true;
    }

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if(entity instanceof Account){
            logger.debug("Account created with account number: "+((Account) entity).getAccountNumber());
        }
        return true;
    }



}
