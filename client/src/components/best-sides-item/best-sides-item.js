import "./best-sides-item.scss";

export default function BestSidesItem({image, title, text}) {
    return (
        <div className="best-sides-item">
            <div className="best-sides-item__image"><img src={image}></img></div>

            <div className="best-sides-item__container">
                <div className="best-sides-item__container__title"><p>{title}</p></div>
                <div className="best-sides-item__container__text"><p>{text}</p></div>
            </div>
        </div>
    )
}