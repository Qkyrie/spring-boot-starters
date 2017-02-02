#!/usr/bin/env bash
if [ "$TRAVIS_BRANCH" = 'master' ] && [ "$TRAVIS_PULL_REQUEST" == 'false' ]; then
    openssl aes-256-cbc -K $encrypted_SOME_key -iv $encrypted_SOME_iv -in scripts/continuous-integration/signingkey.asc.enc -out scripts/continuous-integration/signingkey.asc -d
    gpg --fast-import scripts/continuous-integration/signingkey.asc
fi