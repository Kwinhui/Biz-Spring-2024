document.addEventListener("DOMContentLoaded", () => {
  const table = document.querySelector("tbody");

  table.addEventListener("click", (e) => {
    const target = e.target;

    if (target.tagName === "TD") {
      const TR = target.closest("TR");
      const pcode = TR.dataset.pcode;
      //   alert(pcode);

      document.location.href = `${rootPath}/product/detail?p_code=${pcode}`;
    }
  });
});
