#!/bin/bash
test `curl --noproxy localhost localhost:8084/sum?a=1\\&b=2` -eq 3
exit $?