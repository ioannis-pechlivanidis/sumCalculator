#!/bin/bash
test `curl --noproxy 192.168.1.4 192.168.1.4:8084/sum?a=1\\&b=2` -eq 3
exit $?