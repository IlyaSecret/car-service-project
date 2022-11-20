import "./sign-in-form.scss";

export default function SignInForm() {
  return (
    <div className="sign-in-form">
        <div className="sign-in-form__form">
          <p className="sign-in-form__form__title">Записаться на ремонт</p>
          <div className="sign-in-form__name">
            <img src="../../img/human.png"></img>
            <input type="text"  placeholder="Имя"></input>
          </div>
          <div className="sign-in-form__phone">
          <img src="../../img/phone.png"></img>
          <input type="text"  placeholder="Телефон"></input>
          </div>
          
          <button id="sign-in-form__button" >Отправить</button>
        </div>
        <div className="filler"></div>
    </div>
  );
}
