document.addEventListener("DOMContentLoaded", () => {
  const btn_update = document.querySelector("input.btn_update");
  const btn_delete = document.querySelector("input.btn_delete");
  btn_update.addEventListener("click", (e) => {
    const target = e.target;
    const io_seq = target.dataset.io_seq;
    // alert(io_seq);
    document.location.href = `${rootPath}/update?io_seq=${io_seq}`;
  });
  btn_delete.addEventListener("click", (e) => {
    const io_seq = e.target.dataset.io_seq;
    const ioSeq = e.target.dataset.io_seq;

    if (confirm("정말 삭제할까요?")) {
      document.location.replace(`${rootPath}/delete/${ioSeq}`);
    }
  });
});
