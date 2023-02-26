FROM ubuntu:20.04 as base

ARG PKGS="git curl unzip zip sudo"

SHELL ["/bin/bash", "-c"]

RUN apt-get update; \
    apt-get -y install ${PKGS}; \
    apt-get clean; \
    apt-get autoremove --yes; \
    rm -rf /var/lib/apt/lists/* \
;

FROM base as sdkman

ARG USER_NAME=root

RUN set -eux; \
    su ${USER_NAME} --command \
    'curl -s "https://get.sdkman.io" | bash \
    && source "${HOME}/.sdkman/bin/sdkman-init.sh"'

FROM sdkman as java

ARG USER_NAME=root
ARG JAVA_VERSION=18.0.2-tem

RUN set -eux; \
    su ${USER_NAME} --command \
    'source "${HOME}/.sdkman/bin/sdkman-init.sh" \
    && sdk install java "${JAVA_VERSION}"'

FROM java as gradle
ARG USER_NAME=root
ARG GRADLE_VERSION=7.5.1

RUN su ${USER_NAME} --command \
    'source "${HOME}/.sdkman/bin/sdkman-init.sh" \
    && sdk install gradle ${GRADLE_VERSION}'
