Problem:
Spring Boot API and upload it on the GitHub. You should include Unit Test and readme.txt file.
Implement a RESTFul API spring-boot application that provides the following APIs:
• API to upload a file with a few meta-data fields. Persist meta-data in persistence store (In memory DB or file system and store the content on a file system)
• API to get file meta-data
• API to search for file IDs with a search criterion (Optional)
• Write a scheduler in the same app to poll for new items in the last hour and send an email (Optional)



Solution:
API's exposed by file uplaod rest service:
- POST http://localhost:8080/files : To upload file
- GET http://localhost:8080/files/5d286ab5-233b-4184-b7fa-defedcd2528b: To get file metadata by UUID
- GET http://localhost:8080/files : To get all files metadata


Steps:
1. Import in eclipse, (Requires eclipse oxygen and JDK-8)
2. Run Spring boot main class - RestServicesApplication
3. To test by use postman or execute test case - RestServicesApplicationTests


