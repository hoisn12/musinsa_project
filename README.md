# musinsa_project
 
### database: H2
### java: 17
폴더 구조는 포트어댑터(핵사고날) 아키텍처 기반으로 설계하였습니다.

상품 테이블, 브랜드 테이블, 카테고리 테이블이 있으며, 상품은 price(원가), sale_price(할인가) 가 있고 sale_price 기준으로 계산되었습니다.

spring boot 3, JPA, queryDSL, mapStruct 가 사용되었습니다.

빌드방법: 소스 폴더에서 ./gradlew build 

실행방법: java -jar ./build/libs/musinsa-0.0.1-SNAPSHOT.jar  

상품 데이터는 app 실행시 자동으로 H2 database에 등록됩니다.


## 구현 API
카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회하는 API
- GET http://localhost:8081/api/products/prices/lowest/category

단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회하는 API
- GET http://localhost:8081/api/products/prices/lowest/brand

카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API
- GET http://localhost:8081/api/products/category/lowhigh?name=상의

브랜드 및 상품을 추가 / 업데이트 / 삭제하는 API
### 브랜드
### 등록
POST http://localhost:8081/api/brands
body : {
"title": "brand 33",
"joinDate": "20241015"
"description": "test"
}

### 수정
PUT http://localhost:8081/api/brands
body : {
"id": "44f1cee27a6e472a8470a059b5b18dcd",
"title": "bra",
"description": null,
"joinDate": "20241015"
}

### 삭제
DELETE http://localhost:8081/api/brands/4b22483081ee4d0ca6ebdd08fb06ac41

### 상품
### 상품등록
POST http://localhost:8081/api/products
body : {
"title": "test",
"brandId": "4bcf18ec475441cdb4df221794692814",
"categoryId": "15b70eae642d4a3790fc2302d179594a",
"price": 11000,
"salePrice": 11000
}

### 상품수정
PUT http://localhost:8081/api/products
body : {
"id": "41ca22194d1d413381a1935fb39aa4bf"
"title": "test",
"brandId": "4bcf18ec475441cdb4df221794692814",
"categoryId": "15b70eae642d4a3790fc2302d179594a",
"price": 11000,
"salePrice": 11000
}

### 상품삭제
DELETE http://localhost:8081/api/products/4b22483081ee4d0ca6ebdd08fb06ac41

### 카테고리 조회
GET http://localhost:8081/api/category