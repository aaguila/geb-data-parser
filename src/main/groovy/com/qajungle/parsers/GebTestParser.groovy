package com.qajungle.parsers

/**
 * Parser for functional tests
 */
class GebTestParser {

    private static String STATUS_OK = "OK"
    private static String STATUS_KO = "KO"

    /**
     * Parse Geb test XML and publish results to database
     * @param test project
     * @param test result url
     * @param job id
     * @return testsuite id
     */
    def parseGebXml(String url){

        def results = new XmlParser().parse(url)

        results.testsuite.each { testsuite ->
            println ""
            println "-----------------------------"
            println "Parsing: ${testsuite.@name} "
            println "Errors: ${testsuite.@errors} "
            println "Failures: ${testsuite.@failures} "
            println "Tests: ${testsuite.@tests} "
            println "Time: ${testsuite.@time} "
            println "Timestamp: ${testsuite.@timestamp} "
            println "-----------------------------"
            println ""

            def date = "${testsuite.@timestamp}".split('T')

            testsuite.testcase.each { testcase ->
                String status = STATUS_OK
                println ""
                println "-----------------------------"
                println "Testcase: ${testcase.@name} "
                println "Time: ${testcase.@time} "
                if(testcase.failure.size() != 0) {
                    println "Status ${STATUS_KO} - Failure"
                    println "Message: ${testcase.failure.@message}"
                }else if (testcase.error.size() != 0){
                    println "Status ${STATUS_KO} - Error"
                    println "Message: ${testcase.error.@message}"
                }else{
                    println "Status: ${STATUS_OK} "
                }
                println "-----------------------------"
                println ""

            }
        }

    }

}
