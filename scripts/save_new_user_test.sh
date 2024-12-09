#!/bin/bash
curl -v -X POST 'http://localhost:8080/user' \
  -H "Content-Type: application/json" \
  -d '{
        "username": "ivan3",
        "password": "12345"
      }' | jq

