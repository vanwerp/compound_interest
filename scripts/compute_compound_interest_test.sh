#!/bin/bash
curl -v -X POST 'http://localhost:8080/capital' \
  -H "Content-Type: application/json" \
  -d '{
        "time": 5,
        "compoundingPeriod": "MONTHLY",
        "initialCapital": 5000,
        "revenue": 5
      }' | jq
