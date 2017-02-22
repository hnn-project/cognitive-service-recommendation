# cognitive-service-recommendation
Azure Cognitive Service Recommendations API repo

##Cognitive Service Recommendations API - workflow
전체 과정을 수행하기 위해 아래의 과정을 수행  

###Azure Cognitive Service 생성 및 관리 UI 접근
- Azure Portal에서 Cognitive Service(preview)를 생성
- 생성시 Type을 Recommendations API로 설정
- 생성 후 만들어진 Cognitive Service에서 Key를 확인
- 생성된 키를 [Recommendations UI](https://recommendations-portal.azurewebsites.net)에서 로그인

###Recommendations Model 생성
모델을 생성하기 위해 Project를 하나 UI에서 생성 후 catalog와 usage를 올로 Build 수행.  
완료된 build에 대해 score 과정을 수행해 recommendations가 처리 되는지 확인

###Recommendations API의 Rest API 추적
Postman을 이용해 score 처리 dev/test 수행  

####HTTP GET 방식  
```
https://westus.api.cognitive.microsoft.com/recommendations/v4.0/models/<MODEL-ID>/recommend/item?itemIds=K4W-00033&numberOfResults=5&buildId=1609558&includeMetadata=false&minimalScore=0
```

#### HTTP Header 정보
```
Accept:application/json, text/javascript, */*; q=0.01
Ocp-Apim-Subscription-Key:<API-KEY>
Accept-Language:ko
Accept-Encoding:gzip, deflate, peerdist
Host:westus.api.cognitive.microsoft.com
Connection:Keep-Alive
```

http request 후 아래와 같은 JSON response 받음  
```
{
  "recommendedItems": [
    {
      "items": [
        {
          "id": "K4W-00035",
          "name": "GC-Xbox LIVE US PK Lic Online ESD 35 USD"
        }
      ],
      "rating": 0.67844837835945,
      "reasoning": [
        "People who like 'GC-Xbox LIVE US PK Lic Online ESD 25 USD' also like 'GC-Xbox LIVE US PK Lic Online ESD 35 USD'"
      ]
    },
    {
      "items": [
        {
          "id": "K4W-00034",
          "name": "GC-Xbox LIVE US PK Lic Online ESD 30 USD"
        }
      ],
      "rating": 0.678349802397801,
      "reasoning": [
        "People who like 'GC-Xbox LIVE US PK Lic Online ESD 25 USD' also like 'GC-Xbox LIVE US PK Lic Online ESD 30 USD'"
      ]
    },
    {
      "items": [
        {
          "id": "K4W-00036",
          "name": "GC-Xbox LIVE US PK Lic Online ESD 40 USD"
        }
      ],
      "rating": 0.677817860626959,
      "reasoning": [
        "People who like 'GC-Xbox LIVE US PK Lic Online ESD 25 USD' also like 'GC-Xbox LIVE US PK Lic Online ESD 40 USD'"
      ]
    },
    {
      "items": [
        {
          "id": "K4W-00039",
          "name": "GC-Xbox LIVE US PK Lic Online ESD 60 USD"
        }
      ],
      "rating": 0.677116803350382,
      "reasoning": [
        "People who like 'GC-Xbox LIVE US PK Lic Online ESD 25 USD' also like 'GC-Xbox LIVE US PK Lic Online ESD 60 USD'"
      ]
    },
    {
      "items": [
        {
          "id": "K4W-00040",
          "name": "GC-Xbox LIVE US PK Lic Online ESD 70 USD"
        }
      ],
      "rating": 0.677005488688014,
      "reasoning": [
        "People who like 'GC-Xbox LIVE US PK Lic Online ESD 25 USD' also like 'GC-Xbox LIVE US PK Lic Online ESD 70 USD'"
      ]
    }
  ]
}
```

###node.js Rest clint를 이용해 API 호출  
nodejs 코드 참조  

###Java Rest clint를 이용해 API 호출  
java 코드 참조  

EOF