#!/bin/bash
curl -v -X GET 'http://localhost:8080/user/me' \
  -u ivan:12345 | jq
