document.addEventListener("DOMContentLoaded", () => {
  const tbody = document.querySelector("tbody");

  tbody.addEventListener("click", (e) => {
    const target = e.target;
    if (target.tagName === "TD") {
      const TR = target.closest("TR");
      const io_seq = TR.dataset.io_seq;
      //   alert(io_seq);

      document.location.href = `${rootPath}/detail?io_seq=${io_seq}`;
    }
  });
});
