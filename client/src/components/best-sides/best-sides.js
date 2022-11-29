import { BestSidesMock } from "../../mocks/best-sides";
import BestSidesItem from "../best-sides-item/best-sides-item";
import "./best-sides.scss";

export default function BestSides() {
    return (
        <div className="best-sides">
            <div className="best-sides__titile title">Почему наш сервис наилучший?</div>
            <div className="best-sides__cards">
                {BestSidesMock.map(el => {
                    return <BestSidesItem image={el.image} text={el.text} title={el.title}/>
                })}
            </div>
        </div>
    )
}