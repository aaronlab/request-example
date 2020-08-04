import "core-js";
import express from "express";
import bodyParser from "body-parser";
import userRouter from "./routers/userRouter";

const app = express();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

app.use("/", userRouter);

export default app;
