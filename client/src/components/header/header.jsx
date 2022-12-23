import { useEffect, useRef } from "react";
import "./header.scss";

export default function Header() {
  const clickHandler = (position) => {
    window.scrollTo({
      top: position,
      behavior: "smooth",
    });
  };
  return (
    <div className="header">
      <div className="header__top">
        <img src="./img/logo.svg" width="178px" height="64px"></img>

        <div className="header__top__left">
          <p id="header__top__phone">+7 (343) 361-52-26</p>
          <p id="header__top__adress">г. Екатеринбург, ул. Репина, д. 32</p>
        </div>
      </div>

      <div className="header__bottom">
        <nav className="header__bottom__navigation">
          <ul className="header__bottom__navigation__list">
            <li>
              <button id="nav_button" onClick={() => clickHandler(907)}>
                О нас
              </button>
            </li>
            <li>
              <button id="nav_button" onClick={() => clickHandler(1500)}>
                Услуги
              </button>
            </li>
            <li>
              <button id="nav_button" onClick={() => clickHandler(2730)}>
                Контакты
              </button>
            </li>
            <li>
              <button id="nav_button" onClick={() => clickHandler(3480)}>
                Галерея
              </button>
            </li>
            <li>
              <button id="nav_button" onClick={() => clickHandler(4480)}>
                Отзывы
              </button>
            </li>
            <li id="header_lk">Личный кабинет</li>
          </ul>
        </nav>
      </div>
    </div>
  );
}
