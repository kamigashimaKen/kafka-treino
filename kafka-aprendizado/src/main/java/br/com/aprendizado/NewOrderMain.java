package br.com.aprendizado;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.metrics.stats.Value;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //passando as propriedades do producer
        var producer = new KafkaProducer<String, String>(properties());

        //valor da msg
        var value = "{\"order_id\":\"1\",\"nome\":\"Ken\",\"idade\":\"30\"}";

        var record = new ProducerRecord<>("APRENDIZADO_NEW_ORDER_TESTE", "APRENDIZADO_NEW_ORDER", value);
        producer.send(record, (data, ex) -> {
            if (null != ex){
                ex.printStackTrace();
                return;
            }
            System.out.println("Sucesso enviando " + data.topic() + ":::partition" + data.partition() +
                    "/offset" + data.offset() + "/timestamp" + data.timestamp());
            System.out.println("Value: " + record.value());
        }).get();
    }

    private static Properties properties() {
        var properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return properties;
    }


}
