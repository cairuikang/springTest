pipeline {
    agent {
        // 此处设定构建环境，目前可选有
        // default, java-8, python-3.5, ruby-2.3, go-1.11 等
        // 详情请阅 https://dev.tencent.com/help/knowledge-base/how-to-use-ci#agents
        label "default"
    }
    stages  {
        
        stage("检出") {
            steps {
                sh 'ci-init'
                checkout(
                    [$class: 'GitSCM', branches: [[name: env.GIT_BUILD_REF]], 
                    userRemoteConfigs: [[url: env.GIT_REPO_URL]]]
                )
            }
        }

        stage("构建") {
            steps {
                echo "构建中..."
                sh 'go version'
                sh 'node -v'
                sh 'java -version'
                sh 'php -v'
                sh 'python -V'
                sh 'gcc -v'
                sh 'make -v'
                // 请在这里放置您项目代码的单元测试调用过程，例如:
                // sh 'mvn package' // mvn 示例
                // sh 'make' // make 示例
                echo "构建完成."
              
                // 演示怎样产生构建物
                script{
                    def exists = fileExists 'README.md'
                    if (!exists) {
                        writeFile(file: 'README.md', text: 'Helloworld')
                    }
                }
                archiveArtifacts artifacts: 'README.md', fingerprint: true
              
                // archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true // 收集构建产物
            }
        }

        stage("测试") {
            steps {
                echo "单元测试中..."
                // 请在这里放置您项目代码的单元测试调用过程，例如:
                // sh 'mvn test' // mvn 示例
                // sh 'make test' // make 示例
                echo "单元测试完成."
              
                // 演示怎么样生成测试报告
                writeFile(file: 'TEST-demo.junit4.AppTest.xml', text: '''
                    <testsuite name="demo.junit4.AppTest" time="0.053" tests="3" errors="0" skipped="0" failures="0">
                        <properties>
                        </properties>
                        <testcase name="testApp" classname="demo.junit4.AppTest" time="0.003"/>
                        <testcase name="test1" classname="demo.junit4.AppTest" time="0"/>
                        <testcase name="test2" classname="demo.junit4.AppTest" time="0"/>
                    </testsuite>
                ''')
                junit '*.xml'
                // junit 'target/surefire-reports/*.xml' // 收集单元测试报告的调用过程
            }
        }

        stage("部署") {
            steps {
                echo "部署中..."
                // 请在这里放置收集单元测试报告的调用过程，例如:
                // sh 'mvn tomcat7:deploy' // Maven tomcat7 插件示例：
                // sh './deploy.sh' // 自研部署脚本
                echo "部署完成"
            }
        }
    }
}