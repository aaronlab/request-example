import express from "express";
import { root } from "../controllers/userController";

const userRouter = express.Router();

userRouter.post("/", root);

export default userRouter;
