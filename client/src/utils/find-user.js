import { Users } from "../services/users";

export function findUser(userData) {
   return Users.find(el => el.phoneNumber === userData.phoneNumber & el.vehicleNumber === userData.vehicleNumber);
}