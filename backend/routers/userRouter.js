import express from "express";
import routes from "../routes";
import {
  user,
  join,
  login,
  userDetail,
  postUser,
  postJoin,
  postLogin,
  postUserDetail,
} from "../controllers/userController";

const userRouter = express.Router();

userRouter.get(routes.root, user);
userRouter.get(routes.join, join);
userRouter.get(routes.login, login);
userRouter.get(routes.userDetail, userDetail);

userRouter.post(routes.root, postUser);
userRouter.post(routes.join, postJoin);
userRouter.post(routes.login, postLogin);
userRouter.post(routes.userDetail, postUserDetail);

export default userRouter;
