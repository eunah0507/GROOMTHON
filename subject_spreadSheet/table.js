//설정
const line = 9;
const header = [" ", "A", "B", "C", "D", "E", "F", "G", "H", "I"];

//첫줄 생성
let tmp = document.createElement("tr");
for (let h of header) {
  tmp.innerHTML += `<th scope="col" id="up${h}" class="thDefault">${h}</th>`;
}
document.getElementById("tableData").append(tmp);

//line 수 만큼 생성
for (let i = 1; i <= line; i++) {
  let tmp = document.createElement("tr");
  tmp.innerHTML += `<th id="left${i}"  scope="row" class="thDefault">${i}</th>`;

  for (let j = 1; j < header.length; j++) {
    let name = header[j] + "" + i;
    tmp.innerHTML += `<td contenteditable="true" id="${name}" class="innerCell" ></td>`;
  }
  document.getElementById("tableData").append(tmp);
}

for (let d of document.getElementsByClassName("innerCell")) {
  d.onclick = function (el) {
    const id = el.target.id;
    document.getElementById("cell").innerText = `Cell: ${id}`;

    for (let thDocument of document.getElementsByTagName("th")) {
      thDocument.className = "thDefault";
    }
    let number = id.replace(/[^0-9]/g, "");
    let english = id.replace(/[0-9]/g, "");
    document.getElementById("up" + english).className = "thClick";
    document.getElementById("left" + number).className = "thClick";
  };
}
