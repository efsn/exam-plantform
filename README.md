# examination-platform 

启动服务
```shell script
./gradlew run
```

访问API
```
http://localhost:8080/quizzes
http://localhost:8080/papers
```

Paper API

功能|Method|URI
---|---|---
获取所有Paper |GET|/papers
组卷|POST|/papers
重新组卷|PATCH|/papers/:paperId

Quiz API

|功能 |Method |URI|
|--- |--- |--- |
|获取所有Quiz |GET |/quizzes  |
|创建 |POST|/quizzes  |
|修改|PATCH |/quizzes/:quizId |
|删除|DELETE |/quizzes/:quizId |