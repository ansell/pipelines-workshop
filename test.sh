#!/bin/sh

INPUT_PATH=/home/mint/gitrepos/gbif-demo/pipelines-workshop/src/main/resources/dwca-usac_mammals-v8.1.zip
OUTPUT_PATH=/home/mint/gitrepos/gbif-demo/pipelines-workshop/out

java -jar target/pipelines-workshop-1.0-SNAPSHOT-shaded.jar --targetPath="${OUTPUT_PATH}" --inputPath="${INPUT_PATH}" --tempLocation=temp --esHosts=http://localhost:9200  --esIndexName=occurrence
