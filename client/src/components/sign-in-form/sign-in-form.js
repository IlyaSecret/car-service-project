import "./sign-in-form.scss";
import {useState} from 'react';
import Modal from "../modal/modal";
export default function SignInForm() {
  const [isActive, setIsActive] = useState(false);
  return (
    <div className="sign-in-form">
        <div className="sign-in-form__form">
          <p className="sign-in-form__form__title__1">Автосервис Autohelp</p>
          <p className="sign-in-form__form__title">Записаться на ремонт</p>
          <div className="sign-in-form__name">
            <img src="../../img/human.png" className="icons"></img>
            <input type="text"  placeholder="Имя"></input>
          </div>
          <div className="sign-in-form__phone">
            <img src="../../img/phone.png" className="icons"></img>
            <input type="text"  placeholder="Телефон"></input>
          </div>

          <button id="sign-in-form__button" onClick={() => setIsActive(true)}>Отправить</button>
          <div className="sign-in-form__ads">
            <div  className="sign-in-form__ads__text">
              <img src="../../img/checked-inside.png" className="checked"></img>
              <p>Гарантии</p>
            </div>
            <div className="sign-in-form__ads__text">
              <img src="../../img/checked-inside.png" className="checked"></img>
              <p className="sign-in-form__ads__text">Скидки постоянным клиентам</p>
            </div>
          </div>

        </div>
        <div className="filler"></div>
        <Modal active={isActive} setActive={setIsActive}>
            <p className="modal_text">Заявка успешно отправлена</p>
        </Modal>
    </div>
  );
}
