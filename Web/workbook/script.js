
const QuizItem = ({index, answer, question}) => {
  const [userInput, setUserInput] = React.useState(""); 
  const [isCorrectText, setIsCorrectText] = React.useState("");
  const [isCorrectColor, setIsCorrectColor] = React.useState("");

  const confirmAnswer = () => {
    const editeduserInput = userInput.replace(/\s+/g, "").toLowerCase();
    const editedAnswers = answer.map(str => str.replace(/\s+/g, "").toLowerCase());

    if(editedAnswers.includes(editeduserInput)) {
      setIsCorrectText("정답");
      setIsCorrectColor("#3edc81");
    }
    else {
      setIsCorrectText("오답");
      setIsCorrectColor("#ff4d4d");
    }
  }
  const showAnswer = () => {
    const firstAnswer = answer[0];
    setIsCorrectText("정답: " + firstAnswer)
    setIsCorrectColor("green");

  }
  return (
    <>
      <div>
        <span className="wordNum">{index+1}</span>
        <input 
          type="text" 
          className="word" 
          onChange={e => setUserInput(e.target.value)}
          value={userInput}/>
        <button type="button" className="btn-submit"  onClick={confirmAnswer}>입력</button>
        <button type="button" className="btn-submit"  onClick={showAnswer}>정답보기</button>
        <span className="isCorrect" style={{color: isCorrectColor}}>{isCorrectText}</span>
      </div>
      <div>
        {question.map((q, i) => (
          <React.Fragment key={i}>
            <br/>{String.fromCharCode(8226) + " " + q}
          </React.Fragment>
        ))}
      </div>
      <br/>
    </>
  );
}

const Form = ({answers, questions}) => {

  const answersLength = Object.keys(answers).length;

  return (
    <>
    {Array.from({length: answersLength}, (_, i) => 
      (<QuizItem
        key={i}
        index={i}
        answer={answers["no" + (i + 1)]}
        question={questions["no" + (i + 1)]}
      />
    ))}
    </>
    );
};

const MainPage = () => {
  return (
    <>
      <h2 id="html">HTML</h2>
      <Form questions={questionsHTML} answers={answersHTML}/>

      <h2 id="css">CSS</h2>
      <Form questions={questionsCSS} answers={answersCSS}/>

      <h2 id="js">JavaScript</h2>
      <Form answers={answersJS} questions={questionsJS}/>

      <h2 id="react">React</h2>
      <Form questions={questionsReact} answers={answersReact}/>

      <h2 id="db">DataBase</h2>
      <Form questions={questionsDB} answers={answersDB}/>

      <h2 id="java">Java</h2>
      <Form questions={questionsJava} answers={answersJava}/>
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
      <a href="#db">DataBase</a>
      <a href="#java">Java</a>
    </div>
  );
}
ReactDOM.createRoot(document.getElementById("rootTitle")).render(<Title text={"웹 단어집"}/>);
ReactDOM.createRoot(document.getElementById("rootNav")).render(<Nav/>);
ReactDOM.createRoot(document.getElementById("rootMainPage")).render(<MainPage/>);
