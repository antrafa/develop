import React, { Component } from 'react';

import { createStackNavigator, createAppContainer } from 'react-navigation'
import HomeScreen from './src/screens/HomeScreen'
import EMOMScreen from './src/screens/EMOMScreen'
import IsometriaScreen from './src/screens/IsometriaScreen'
import AMRAPScreen from './src/screens/AMRAPScreen'
import SobreScreen from './src/screens/SobreScreen'

const AppNavigator = createStackNavigator({
    Home: HomeScreen,
    EMOM: EMOMScreen,
    AMRAP: AMRAPScreen,
    Isometria: IsometriaScreen,
    Sobre: SobreScreen
  }, { initialRouteName: 'Home' }
)

export default createAppContainer(AppNavigator)