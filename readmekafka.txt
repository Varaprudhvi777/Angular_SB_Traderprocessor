==============

C:\kafka_2.12-2.7.0>.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

==============

C:\kafka_2.12-2.7.0>.\bin\windows\kafka-server-start.bat .\config\server.properties

=========

C:\kafka_2.12-2.7.0>.\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic tradeprocessornew

================

C:\kafka_2.12-2.7.0>.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic tradeprocessornew

==========

C:\kafka_2.12-2.7.0>.\bin\windows\kafka-console-consumer.bat --bootstrap-servers localhost:9092 --topic tradeprocessornew --from-beginning