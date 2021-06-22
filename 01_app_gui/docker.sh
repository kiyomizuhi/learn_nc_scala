docker build \
--build-arg SBT_VERSION="1.3.5" \
--build-arg SCALA_VERSION="2.13.0" \
--build-arg USER_ID=1001 \
--build-arg GROUP_ID=1001 \
-t scala01 \
.

docker run --rm -it -v $(pwd):/home/work -e DISPLAY="192.168.0.3:0" scala01 bash

# socat TCP-LISTEN:6000,reuseaddr,fork UNIX-CLIENT:\"$DPLAY\"