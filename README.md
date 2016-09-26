# layered_jee_application
This repository created for JEE internal trainings

1. You can build with this project with mvn clean install command from the root folder.
2. After a success build, you can deploy to any JEE 7 compliant app server. It tested only Payara Server 4.1.1.163 #badassfish (build 215)
3. During the deployment JPA persist initial data to the database. This example uses the default Derby database which comes with the  application server. See persistence.xml in persistence-layer artifact.
4. You can check the working REST API endpoint under this path: $HOSTNAME/web-layer/rest/stocks with GET method.
