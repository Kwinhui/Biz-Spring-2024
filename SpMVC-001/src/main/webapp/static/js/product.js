document.addEventListener("DOMContentLoaded", () => {
  const table = document.querySelector("tbody");
  const btn_update = document.querySelector("input.btn_update");
  const btn_delete = document.querySelector("input.btn_delete");
  table?.addEventListener("click", (e) => {
    const target = e.target;

    if (target.tagName === "TD") {
      const TR = target.closest("TR");
      const pcode = TR.dataset.pcode;
      //   alert(pcode);

      document.location.href = `${rootPath}/product/detail?p_code=${pcode}`;
    }
  });

  btn_update?.addEventListener("click", (e) => {
    const target = e.target;
    const pcode = target.dataset.pcode;

    document.location.href = `${rootPath}/product/update?pCode=${pcode}`;
  });
  btn_delete.addEventListener("click", (e) => {
    const pcode = e.target.dataset.pcode;
    if (confirm("정말 삭제할까요?")) {
      document.location.replace(`${rootPath}/product/delete/${pcode}`);
    }
  });
});
