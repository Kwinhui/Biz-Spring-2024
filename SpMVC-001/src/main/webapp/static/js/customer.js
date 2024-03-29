document.addEventListener("DOMContentLoaded", () => {
  const cust_body = document.querySelector("tbody.cust_body");
  const btn_update = document.querySelector("input.btn_update");
  const btn_delete = document.querySelector("input.btn_delete");

  const cust_body_onClick_handler = (e) => {
    const target = e.target;
    if (target.tagName === "TD") {
      // 눌린태그가 TD이면
      const TR = target.closest("TR");
      // TD랑 가장가까운 TR을 찾아
      const ccode = TR.dataset.ccode;

      // alert(ccode);
      document.location.href = `${rootPath}/customer/detail?c_code=${ccode}`;
    }
  };
  cust_body.addEventListener("click", cust_body_onClick_handler);

  btn_update.addEventListener("click", (e) => {
    const ccode = e.target.dataset.ccode;
    alert(ccode);
  });
});
