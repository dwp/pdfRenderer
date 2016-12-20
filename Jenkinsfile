node ('master') {
    def server = Artifactory.server('newlab-artifactory')
    def artifactoryGradle = Artifactory.newGradleBuild()
    artifactoryGradle.tool = 'Gradle321' // Tool name from Jenkins configuration
    artifactoryGradle.deployer repo:'libs-snapshot-local', server: server
    artifactoryGradle.resolver repo:'repo', server: server
    artifactoryGradle.deployer.ivyPattern = '[organisation]/[module]/ivy-[revision].xml'
    artifactoryGradle.deployer.artifactPattern = '[organisation]/[module]/[revision]/[artifact]-[revision](-[classifier]).[ext]'
    artifactoryGradle.deployer.mavenCompatible = true
    artifactoryGradle.deployer.usesPlugin = true

    def buildInfo = Artifactory.newBuildInfo()
    buildInfo.env.capture = true
    buildInfo.env.filter.addInclude("")
    buildInfo.env.filter.addExclude("DONT_COLLECT*")
    
    def artifactoryMaven = Artifactory.newMavenBuild()
    artifactoryMaven.resolver releaseRepo:'repo', snapshotRepo:'repo', server: server


    stage ('Checkout') {
        checkout scm
    }
    stage ('Build') {
        try {
            withEnv(['_JAVA_OPTIONS=-Dcarers.keystore=/opt/carers-keystore/carerskeystore']) {
                artifactoryGradle.run switches: '-Dgradle.user.home=$JENKINS_HOME/.gradle', buildFile: 'build.gradle', tasks: 'clean test build sourcesJar artifactoryPublish', buildInfo: buildInfo, server: server
            }
            publishHTML([allowMissing: true, alwaysLinkToLastBuild: false, keepAll: true, reportDir: 'build/reports/tests/test/', reportFiles: 'index.html', reportName: 'Test Report'])
            junit keepLongStdio: true, testResults: 'build/test-results/test/*.xml'
        } catch (Exception e) {
            publishHTML([allowMissing: true, alwaysLinkToLastBuild: false, keepAll: true, reportDir: 'build/reports/tests/test/', reportFiles: 'index.html', reportName: 'Test Report'])
            junit allowEmptyResults: true, keepLongStdio: true, testResults: 'build/test-results/test/*.xml'
            throw e;
        }
    }
    stage ('Publish build info') {
        server.publishBuildInfo buildInfo
    }
}
