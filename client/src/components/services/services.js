import "./services.scss";

export default function Services() {
  return (
    <div className="services">
      <p className="services__title">Услуги автосервиса</p>

      <div className="services_cards"> 
        <div className="servies__card">
          <div className="servies__card__image one">

          </div>
          <div className="servies__card__text">
              <p className="servies__card__title">
                Капитальный ремонт ДВС
              </p>
              <p className="servies__card__info">
              Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. 
              </p>
          </div>
        </div>
        <div className="servies__card">
          <div className="servies__card__image two">

          </div>
          <div className="servies__card__text">
              <p className="servies__card__title">
              Капитальный ремонт МКПП
              </p>
              <p className="servies__card__info">
              Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. 
              </p>
          </div>
        </div>
        <div className="servies__card">
          <div className="servies__card__image three">

          </div>
          <div className="servies__card__text">
              <p className="servies__card__title">
              Заправка кондиционера
              </p>
              <p className="servies__card__info">
              Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. 
              </p>
          </div>
        </div>
        <div className="servies__card">
          <div className="servies__card__image four">

          </div>
          <div className="servies__card__text">
              <p className="servies__card__title">
              Ремонт ходовой части
              </p>
              <p className="servies__card__info">
              Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. 
              </p>
          </div>
        </div>

        <div className="servies__card">
          <div className="servies__card__image five">

          </div>
          <div className="servies__card__text">
              <p className="servies__card__title">
                Ремонт лампочек
              </p>
              <p className="servies__card__info">
              Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. 
              </p>
          </div>
        </div>
      </div>
    </div>
  )
}
