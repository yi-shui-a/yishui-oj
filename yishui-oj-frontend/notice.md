## 问题1：无法获取session

在 `generated\core\OpenAPI.ts` 路径下的

```typescript
export const OpenAPI: OpenAPIConfig = {
    BASE: 'http://localhost:8101',
    VERSION: '1.0',
    WITH_CREDENTIALS: true,
    CREDENTIALS: 'include',
    TOKEN: undefined,
    USERNAME: undefined,
    PASSWORD: undefined,
    HEADERS: undefined,
    ENCODE_PATH: undefined,
};
```

+ BASE：指定后端 API 的基础 URL（Base URL）。可能会出现两个api字段，删除一个就行。

+ VERSION：标识 API 的版本号（通常用于文档或请求头）。可选字段，具体是否生效取决于后端实现。

+ WITH_CREDENTIALS：控制是否在跨域请求中发送凭据（如 Cookies、HTTP 认证头）。（必须为true，否则后端无法获取session）

+ CREDENTIALS：与 `WITH_CREDENTIALS` 类似，但更具体化，定义 Fetch API 的凭据模式。

  > **可选值**：
  >
  > - `'include'`：发送凭据（同 `WITH_CREDENTIALS: true`）。
  > - `'same-origin'`：仅同源请求发送凭据。
  > - `'omit'`：不发送凭据。

+ TOKEN：用于设置全局的认证 Token（如 JWT）。

  > **使用场景**：
  >
  > - 如果接口需要 
  >
  >   ```
  >   Authorization: Bearer <token>
  >   ```
  >
  >   ，可以在此配置：
  >
  >   ts
  >
  >   ```ts
  >   TOKEN: 'your_jwt_token_here',
  >   ```
  >
  > - 动态 Token 通常在请求拦截器中设置（如从 localStorage 读取）。

+ USERNAME：用于 HTTP 基本认证（Basic Auth）。

+ PASSWORD：同上。如果设置了这两个字段，客户端会自动生成 `Authorization: Basic <base64>` 请求头。

+ HEADERS：定义全局自定义请求头。

  > **示例**：
  >
  > ```ts
  > HEADERS: {
  >   'X-Custom-Header': 'value',
  >   'Accept-Language': 'en-US',
  > },
  > ```

+ ENCODE_PATH：控制是否对 URL 路径进行编码（默认由生成器自动处理）。

  > **示例**：
  >
  > - 如果路径包含特殊字符（如 `/api/user/name@domain`），设为 `true` 会编码为 `/api/user/name%40domain`。





23