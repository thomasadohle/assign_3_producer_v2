package messaging;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class ConnectionPool extends GenericObjectPool<Connection> {

    private static ConnectionPool instance;

    private ConnectionPool(PooledObjectFactory<Connection> factory, GenericObjectPoolConfig config) {
        super(factory, config);
    }

    public static ConnectionPool getInstance(){
        if (instance == null){
            GenericObjectPoolConfig config = new GenericObjectPoolConfig();
            config.setMinIdle(64);
            config.setMaxIdle(128);
            config.setMaxTotal(128);
            PooledObjectFactory<Connection> factory = new messaging.ConnectionFactoryImpl();
            instance = new ConnectionPool(factory, config);
        }
        return instance;
    }


}
