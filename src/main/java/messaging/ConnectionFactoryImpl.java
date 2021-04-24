package messaging;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConnectionFactoryImpl extends BasePooledObjectFactory<Connection> {

    ConnectionFactory factory = new ConnectionFactory();

    @Override
    public Connection create() {
        return this.getConnection();
    }

    private Connection getConnection() {
        Connection connection = null;
        try{
            connection = factory.newConnection();
        } catch (IOException|TimeoutException e){
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Use the default PooledObject implementation.
     */
    @Override
    public PooledObject<Connection> wrap(Connection connection) {
        return new DefaultPooledObject<Connection>(connection);
    }

    /**
     * When an object is returned to the pool, clear the buffer.
     */
    @Override
    public void passivateObject(PooledObject<Connection> pooledObject) {

    }

}
