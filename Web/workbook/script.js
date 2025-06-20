
const answersHTMLLength = Object.keys(answersHTML).length;
const answersCSSLength = Object.keys(answersCSS).length;
const answersJSLength = Object.keys(answersJS).length;
const answersReactLength = Object.keys(answersReact).length;

// const containerHTML = document.getElementById("containerHTML");
// const containerCSS = document.getElementById("containerCSS");
// const containerJS = document.getElementById("containerJS");
// const containerReact = document.getElementById("containerReact");

const kind = ["HTML", "CSS", "JS", "React"];

const Data = ({index, q}) => {
  const key = "no" + (index+1);
  const data = q[key].map((item, i) => {
    return (
      <React.Fragment key={i}>
        <br/>{String.fromCharCode(8226) + item}
      </React.Fragment>
    );
  })
  return (
    <>{data}</>
  )
}

const Form = ({kind, a, q, as}) => {

  const [userInputs, setUserInputs] = React.useState({}); 

  const handleBlur = (e) => {
    setUserInputs(prev => ({...prev, [e.target.id] : e.target.value}));
  }

  const confirmAnswer = (e) => {
    const userInput = userInputs[e.target.id.replace("btn-submit", "word")];
    console.log(userInput, as["no" + e.target.id.at(-1)]);
  }
  const showAnswer = (e) => {

  }
  

  const form = Array.from({length: a}, (_, i) => {
  return (
    <React.Fragment key={i}>
      <div>
        <span className="wordNum">{i+1}</span>
        <input type="text" className="word" id={"word" + kind + (i+1)} onBlur={handleBlur} value={userInputs[i]}/>
        <button type="button" className="btn-submit" id={"btn-submit" + kind + (i+1)} onClick={confirmAnswer}>입력</button>
        <button type="button" className="btn-submit" id={"btn-showAnswers" + kind + (i+1)} onClick={showAnswer}>정답보기</button>
        <span className="isCorrect" id={"isCorrect" + kind + (i+1)}></span>
      </div>
      <div>
        <span><Data index={i} q={q}/></span>
      </div>
      <br/>
    </React.Fragment>
  )
  });

  return (<>{form}</>);
}

const MainPage = () => {
  return (
    <>
      <h2 id="html">HTML</h2>
      <Form kind={kind[0]} a={answersHTMLLength} q={questionsHTML} as={answersHTML}/>

      <h2 id="css">CSS</h2>
      <Form kind={kind[1]} a={answersCSSLength} q={questionsCSS}/>

      <h2 id="js">JavaScript</h2>
      <Form kind={kind[2]} a={answersJSLength} q={questionsJS}/>

      <h2 id="react">React</h2>
      <Form kind={kind[3]} a={answersReactLength} q={questionsReact}/>
    </>
  );
}
const Title = ({text}) => {
  return (
    <h1 className="title">{text}</h1>
  );
}
const Nav = () => {
  return (
    <div id="nav">
      <a href="#html">HTML</a>
      <a href="#css">CSS</a>
      <a href="#js">JavaScript</a>
      <a href="#react">React</a>
    </div>
  );
}
ReactDOM.createRoot(document.getElementById("rootTitle")).render(<Title text={"웹(HTML, CSS, JavaScript + React) 단어집"}/>);
ReactDOM.createRoot(document.getElementById("rootNav")).render(<Nav/>);
ReactDOM.createRoot(document.getElementById("rootMainPage")).render(<MainPage/>);



// for(let n=0; n<answersHTMLLength; n++) {
//   document.getElementById(`btn-submitHTML${n+1}`).addEventListener("click", () => {
//     const word = document.getElementById(`wordHTML${n+1}`).value;
//     const editedWord = word.replace(/\s+/g, "").toLowerCase();
//     const editedAnswer = answersHTML[`no${n+1}`].map(str => str.replace(/\s+/g, "").toLowerCase());
//     const isCorrect = document.getElementById(`isCorrectHTML${n+1}`);
    
//     if(editedAnswer.includes(editedWord)) {
//       isCorrect.textContent = "정답";
//       isCorrect.style.color = "#3edc81";
//     }
//     else {
//       isCorrect.textContent = "오답";
//       isCorrect.style.color = "#ff4d4d";
//     }
//   });
//   document.getElementById(`btn-showAnswersHTML${n+1}`).addEventListener("click", () => {
//     const isCorrect = document.getElementById(`isCorrectHTML${n+1}`);
//     isCorrect.textContent = answersHTML[`no${n+1}`][0];
//     isCorrect.style.color = "#3edc81";
//   });
// }



// for(let n=0; n<answersCSSLength; n++) {
//   const key = "no" + (n+1);
//   let str = "";
//   questionsCSS[key].forEach(item => str += "<br>&bull; " + item);

//   str = `
//     <div>
//       <span class="wordNum">${n+1}</span>
//       <input type="text" class="word" id="wordCSS${n+1}">
//       <button type="button" class="btn-submit" id="btn-submitCSS${n+1}">입력</button>
//       <button type="button" class="btn-submit" id="btn-showAnswersCSS${n+1}">정답보기</button>
//       <span class="isCorrect" id="isCorrectCSS${n+1}"></span>
//     </div>
//     <div>
//       <span>`
//         + str +
//       `</span>
//     </div>
//     <br>
//   `;
//   containerCSS.innerHTML += str;
// }

// for(let n=0; n<answersCSSLength; n++) {
//   document.getElementById(`btn-submitCSS${n+1}`).addEventListener("click", () => {
//     const word = document.getElementById(`wordCSS${n+1}`).value;
//     const editedWord = word.replace(/\s+/g, "").toLowerCase();
//     const editedAnswer = answersCSS[`no${n+1}`].map(str => str.replace(/\s+/g, "").toLowerCase());
//     const isCorrect = document.getElementById(`isCorrectCSS${n+1}`);
    
//     if(editedAnswer.includes(editedWord)) {
//       isCorrect.textContent = "정답";
//       isCorrect.style.color = "#3edc81";
//     }
//     else {
//       isCorrect.textContent = "오답";
//       isCorrect.style.color = "#ff4d4d";
//     }
//   });
//   document.getElementById(`btn-showAnswersCSS${n+1}`).addEventListener("click", () => {
//     const isCorrect = document.getElementById(`isCorrectCSS${n+1}`);
//     isCorrect.textContent = answersCSS[`no${n+1}`][0];
//     isCorrect.style.color = "#3edc81";
//   });
// }

// for(let n=0; n<answersJSLength; n++) {
//   const key = "no" + (n+1);
//   let str = "";
//   questionsJS[key].forEach(item => str += "<br>&bull; " + item);

//   str = `
//     <div>
//       <span class="wordNum">${n+1}</span>
//       <input type="text" class="word" id="wordJS${n+1}">
//       <button type="button" class="btn-submit" id="btn-submitJS${n+1}">입력</button>
//       <button type="button" class="btn-submit" id="btn-showAnswersJS${n+1}">정답보기</button>
//       <span class="isCorrect" id="isCorrectJS${n+1}"></span>
//     </div>
//     <div>
//       <span>`
//         + str +
//       `</span>
//     </div>
//     <br>
//   `;
//   containerJS.innerHTML += str;
// }

// for(let n=0; n<answersJSLength; n++) {
//   document.getElementById(`btn-submitJS${n+1}`).addEventListener("click", () => {
//     const word = document.getElementById(`wordJS${n+1}`).value;
//     const editedWord = word.replace(/\s+/g, "").toLowerCase();
//     const editedAnswer = answersJS[`no${n+1}`].map(str => str.replace(/\s+/g, "").toLowerCase());
//     const isCorrect = document.getElementById(`isCorrectJS${n+1}`);
    
//     if(editedAnswer.includes(editedWord)) {
//       isCorrect.textContent = "정답";
//       isCorrect.style.color = "#3edc81";
//     }
//     else {
//       isCorrect.textContent = "오답";
//       isCorrect.style.color = "#ff4d4d";
//     }
//   });
//   document.getElementById(`btn-showAnswersJS${n+1}`).addEventListener("click", () => {
//     const isCorrect = document.getElementById(`isCorrectJS${n+1}`);
//     isCorrect.textContent = answersJS[`no${n+1}`][0];
//     isCorrect.style.color = "#3edc81";
//   });
// }

// for(let n=0; n<answersReactLength; n++) {
//   const key = "no" + (n+1);
//   let str = "";
//   questionsReact[key].forEach(item => str += "<br>&bull; " + item);

//   str = `
//     <div>
//       <span class="wordNum">${n+1}</span>
//       <input type="text" class="word" id="wordReact${n+1}">
//       <button type="button" class="btn-submit" id="btn-submitReact${n+1}">입력</button>
//       <button type="button" class="btn-submit" id="btn-showAnswersReact${n+1}">정답보기</button>
//       <span class="isCorrect" id="isCorrectReact${n+1}"></span>
//     </div>
//     <div>
//       <span>`
//         + str +
//       `</span>
//     </div>
//     <br>
//   `;
//   containerReact.innerHTML += str;
// }

// for(let n=0; n<answersReactLength; n++) {
//   document.getElementById(`btn-submitReact${n+1}`).addEventListener("click", () => {
//     const word = document.getElementById(`wordReact${n+1}`).value;
//     const editedWord = word.replace(/\s+/g, "").toLowerCase();
//     const editedAnswer = answersReact[`no${n+1}`].map(str => str.replace(/\s+/g, "").toLowerCase());
//     const isCorrect = document.getElementById(`isCorrectReact${n+1}`);
    
//     if(editedAnswer.includes(editedWord)) {
//       isCorrect.textContent = "정답";
//       isCorrect.style.color = "#3edc81";
//     }
//     else {
//       isCorrect.textContent = "오답";
//       isCorrect.style.color = "#ff4d4d";
//     }
//   });
//   document.getElementById(`btn-showAnswersReact${n+1}`).addEventListener("click", () => {
//     const isCorrect = document.getElementById(`isCorrectReact${n+1}`);
//     isCorrect.textContent = answersReact[`no${n+1}`][0];
//     isCorrect.style.color = "#3edc81";
//   });
// }
