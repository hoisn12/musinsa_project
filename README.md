# musinsa_project
 
### database: H2
### java: 17
폴더 구조는 포트어댑터(핵사고날) 아키텍처 기반으로 설계하였습니다.

구현 API
카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회하는 API
- GET http://localhost:8081/api/products/prices/lowest/category

단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회하는 API
- GET http://localhost:8081/api/products/prices/lowest/brand

카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API
- GET http://localhost:8081/api/products/category/lowhigh?name=상의

브랜드 및 상품을 추가 / 업데이트 / 삭제하는 API
## 브랜드
### 등록
POST http://localhost:8081/api/products
body : {
"title": "test",
"brandId": "4bcf18ec475441cdb4df221794692814",
"categoryId": "15b70eae642d4a3790fc2302d179594a",
"price": 11000,
"salePrice": 11000
}

### 수정
PUT http://localhost:8081/api/products
body : {
"id": "41ca22194d1d413381a1935fb39aa4bf"
"title": "test",
"brandId": "4bcf18ec475441cdb4df221794692814",
"categoryId": "15b70eae642d4a3790fc2302d179594a",
"price": 11000,
"salePrice": 11000
}

### 삭제
DELETE http://localhost:8081/api/products/4b22483081ee4d0ca6ebdd08fb06ac41

## 상품
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

