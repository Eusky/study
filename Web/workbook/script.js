
const kind = ["HTML", "CSS", "JS", "React"];

const QuizItem = ({index, kind, answers, questions}) => {
  const [userInput, setUserInput] = React.useState(""); 
  const [isCorrectText, setIsCorrectText] = React.useState({});
  const [isCorrectColor, setIsCorrectColor] = React.useState({});

  const confirmAnswer = (e) => {
    const editeduserInput = userInputs[e.target.id.replace("btn-submit", "word")].replace(/\s+/g, "").toLowerCase();
    const editedAnswers = as["no" + e.target.id.at(-1)].map(str => str.replace(/\s+/g, "").toLowerCase());
    if(editedAnswers.includes(editeduserInput)) {
      setIsCorrectText(prev => ({...prev, [e.target.id] : "정답"}));
      setIsCorrectColor(prev => ({ ...prev, [e.target.id]: "#3edc81" }));
    }
    else {
      setIsCorrectText(prev => ({...prev, [e.target.id] : "오답"}));
      setIsCorrectColor(prev => ({ ...prev, [e.target.id]: "#ff4d4d" }));
    }
    
  }
  const showAnswer = (e) => {
    const firstAnswer = as["no" + e.target.id.at(-1)][0];
    setIsCorrectText(prev => ({...prev, ["btn-submit" + kind + e.target.id.at(-1)]: "정답: " + firstAnswer}))
    setIsCorrectColor(prev => ({...prev, ["btn-submit" + kind + e.target.id.at(-1)]: "black"}));

  }

  return (
    <React.Fragment key={i}>
      <div>
        <span className="wordNum">{index+1}</span>
        <input 
          type="text" 
          className="word" 
          onChange={e => setUserInput(e.target.value)}
          value={userInput}/>
        <button type="button" className="btn-submit"  onClick={confirmAnswer}>입력</button>
        <button type="button" className="btn-submit"  onClick={showAnswer}>정답보기</button>
        <span className="isCorrect" style={{color: isCorrectColor["btn-submit" + kind + (i + 1)]}}>{isCorrectText["btn-submit" + kind + (i+1)]}</span>
      </div>
      <div>
        <span><Data index={i} q={q}/></span>
      </div>
      <br/>
    </React.Fragment>
  );
}

const Form = ({kind, answers, questions}) => {

  const answersLength = Object.keys(answers).length;

  return (
    <>
    {Array.from({length: a}, (_, i) => 
      (<QuizItem
        key={i}
        index={i}
        kind={kind}
        answers={answers["no" + (i + 1)]}
        questions={questions["no" + (i + 1)]}
      />
    ))}
    </>
    );
};

const MainPage = () => {
  return (
    <>
      <h2 id="html">HTML</h2>
      <Form kind={kind[0]} questions={questionsHTML} answers={answersHTML}/>

      <h2 id="css">CSS</h2>
      <Form kind={kind[1]} a={answersCSSLength} q={questionsCSS} as={answersCSS}/>

      <h2 id="js">JavaScript</h2>
      <Form kind={kind[2]} a={answersJSLength} q={questionsJS} as={answersJS}/>

      <h2 id="react">React</h2>
      <Form kind={kind[3]} a={answersReactLength} q={questionsReact} as={answersReact}/>
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
