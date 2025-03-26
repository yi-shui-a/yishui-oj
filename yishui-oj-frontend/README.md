# yishui-oj-frontend

## 根据后台生成代码

```shell
npm install openapi-generator-cli -g
```

```shell
openapi --input http://localhost:8101/api/v2/api-docs --output ./generated --client axios
```

如果报错：
>openapi : 无法将“openapi”项识别为 cmdlet、函数、脚本文件或可运行程序的名称
>


使用命令：
```shell
npx openapi-typescript-codegen --input http://localhost:8101/api/v2/api-docs --output ./generated --client axios
```

代码生成完毕后，进入 `generated\core\OpenAPI.ts` 目录。

将 `BASE: 'http://localhost:8101/api'`，修改为 `'http://localhost:8101'` 。


## Project setup (yarn)

```
yarn install
```

### Compiles and hot-reloads for development

```
yarn serve
```

### Compiles and minifies for production

```
yarn build
```

### Lints and fixes files

```
yarn lint
```

### Customize configuration

See [Configuration Reference](https://cli.vuejs.org/config/).


## Project setup (npm)
```
npm install
```

### Compiles and hot-reloads for development
```
npm run serve
```