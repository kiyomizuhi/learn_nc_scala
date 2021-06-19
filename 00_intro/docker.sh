docker build \
--build-arg SBT_VERSION="1.3.5" \
--build-arg SCALA_VERSION="2.13.0" \
--build-arg USER_ID=1001 \
--build-arg GROUP_ID=1001 \
-t scala-env \
.

docker run --rm -it -v $(pwd):/home/sbtuser scala-env bash
