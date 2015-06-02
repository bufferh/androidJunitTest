1. 在build.gradle 里添加
testCompile 'junit:junit:4.12'

2. 执行 ./gradlew test 后， 测试结果将以html 形式存在， 路径在app/build/reports/tests/debug/index.html