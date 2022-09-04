#!/bin/bash
set -euxo pipefail

RDS_HOSTNAME=$(/opt/elasticbeanstalk/bin/get-config environment -k RDS_HOSTNAME)
RDS_PORT=$(/opt/elasticbeanstalk/bin/get-config environment -k RDS_PORT)
RDS_USERNAME=$(/opt/elasticbeanstalk/bin/get-config environment -k RDS_USERNAME)
RDS_PASSWORD=$(/opt/elasticbeanstalk/bin/get-config environment -k RDS_PASSWORD)
TMP_DIR=$(/opt/elasticbeanstalk/bin/get-config environment -k TMP_DIR)

echo "Database host: $RDS_HOSTNAME"
echo "Database port: $RDS_PORT"
echo "Database host: $RDS_USERNAME"
echo "Database host: $RDS_PASSWORD"
echo "Database host: $TMP_DIR"


java -jar licenta-0.0.2-SNAPSHOT.jar --spring.datasource.url=jdbc:mysql://$RDS_HOSTNAME:$RDS_PORT/aspp --spring.datasource.username=$RDS_USERNAME --spring.datasource.password=$RDS_PASSWORD -Djava.io.tmpdir=$TMP_DIR