export const root = (req, res) => {
  const {
    body: { message },
  } = req;

  if (message) {
    console.log(`---> Received Data: ${message}`);
  } else {
    console.log("---> Nothing Received");
  }
};
