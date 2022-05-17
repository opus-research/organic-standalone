# organic-standalone
Standalone version of the Organic tool.

## Requirements
Java 11+
Gradle 7.4.1+

## Building and Running

Creating a distribution file:
`gradle distZip`

Running autommated tests:
`gradle test`

Running the tool:
`gradle run --args="-sf 'smells.json' -src 'path_to_analyzed_project'"` 
