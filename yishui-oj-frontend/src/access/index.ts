import router from "@/router";
import store from "@/store";
import ACCESS_ENUM from "@/access/accessEnum";
import checkAccess from "@/access/checkAccess";

router.beforeEach(async (to, from, next) => {
  console.log("登陆用户信息", store.state.user.loginUser);
  let loginUser = store.state.user.loginUser;
  // 如果之前没登陆过，自动登录
  if (!loginUser || !loginUser.userRole) {
    try {
      // 加 await 是为了等用户登录成功之后，再执行后续的代码
      await store.dispatch("user/getLoginUser");
      loginUser = store.state.user.loginUser;
      console.log("获取登录用户信息后", loginUser);
    } catch (error) {
      console.error("获取登录用户信息失败", error);
      loginUser = {
        userRole: ACCESS_ENUM.NOT_LOGIN,
      };
    }
  }
  const needAccess = (to.meta?.access as string) ?? ACCESS_ENUM.NOT_LOGIN;
  console.log("目标页面需要的权限", needAccess);
  // 要跳转的页面必须要登陆
  if (needAccess !== ACCESS_ENUM.NOT_LOGIN) {
    // 如果没登陆，跳转到登录页面
    if (
      !loginUser ||
      !loginUser.userRole ||
      loginUser.userRole === ACCESS_ENUM.NOT_LOGIN
    ) {
      console.log("未登录，跳转到登录页面");
      next(`/user/login?redirect=${to.fullPath}`);
      return;
    }
    // 如果已经登陆了，但是权限不足，那么跳转到无权限页面
    if (!checkAccess(loginUser, needAccess)) {
      console.log("权限不足，跳转到无权限页面");
      next("/noAuth");
      return;
    }
  }
  console.log("权限验证通过，继续跳转");
  next();
});
